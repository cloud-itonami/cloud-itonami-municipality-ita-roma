(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest roma-has-spec-basis
  (let [sb (facts/spec-basis "roma")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.comune.roma.it/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "milano")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["roma" "milano"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["milano"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["roma.regolamento-attivita-commerciali-citta-storica-2023"]
         (mapv :ordinance/id (facts/by-topic "roma" :commerce))))
  (is (empty? (facts/by-topic "roma" :labor)))
  (is (empty? (facts/by-topic "milano" :transparency))))
