(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest roma-has-culture-basis
  (let [sb (facts/spec-basis "roma")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "roma" (:culture/municipality %)) sb))
    (is (every? #(= "ITA" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "milano")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["roma" "milano"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["milano"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 5 (count (facts/by-kind "roma" :dish))))
  (is (= ["roma.beverage.frascati"]
         (mapv :culture/id (facts/by-kind "roma" :beverage))))
  (is (empty? (facts/by-kind "roma" :craft)))
  (is (empty? (facts/by-kind "milano" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
