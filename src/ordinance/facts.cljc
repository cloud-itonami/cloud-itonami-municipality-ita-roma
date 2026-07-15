(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Rome (Roma Capitale) --
  the TENTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul for the first nine) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL comune.roma.it PDF -- never fabricated.
  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/number.

  Both entries below were verified by directly reading the source PDF
  text via the Read tool. The Albo Pretorio deliberation PDF is a
  meeting-minutes extract that incidentally lists Giunta Capitolina
  members' names in an attendance roster -- those names were read only
  to locate the deliberation number/date/title and are NOT stored
  anywhere in this catalog, consistent with this family's no-personal-names
  discipline.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"roma"
   [{:ordinance/id "roma.regolamento-albo-pretorio-online-2021"
     :ordinance/title "Nuovo Regolamento per la disciplina dell'Albo Pretorio on line"
     :ordinance/municipality "roma"
     :ordinance/country "ITA"
     :ordinance/kind :ordinance
     :ordinance/number "Deliberazione di Giunta Capitolina n. 71/2021"
     :ordinance/url "https://www.comune.roma.it/web-resources/cms/documents/Delib_G_C_n__71__2021.pdf"
     :ordinance/url-provenance :official-comune-roma-it
     :ordinance/enacted-date "2021-04-02"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:information-disclosure :transparency}}
    {:ordinance/id "roma.regolamento-attivita-commerciali-citta-storica-2023"
     :ordinance/title "Regolamento per l'esercizio delle attività commerciali e artigianali nel territorio della città storica"
     :ordinance/municipality "roma"
     :ordinance/country "ITA"
     :ordinance/kind :ordinance
     :ordinance/number "Deliberazione di Assemblea Capitolina n. 109/2023"
     :ordinance/url "https://www.comune.roma.it/web-resources/cms/documents/.REGOLAMENTO_ATTIVIT_COMMERCIALI_ARTIGIANALI_CITTA_STORICA_DAC_109_2023pdf.pdf"
     :ordinance/url-provenance :official-comune-roma-it
     :ordinance/enacted-date "2023-05-30"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:licensing :commerce}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-ita-roma Wave 0 (ADR-2607141700): "
                 (count (get catalog "roma")) " Roma entries seeded with "
                 "an official comune.roma.it citation. Extend "
                 "`ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
