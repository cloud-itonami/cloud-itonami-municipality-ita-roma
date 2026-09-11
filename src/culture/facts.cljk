(ns culture.facts
  "Regional-culture catalog for Rome (Roma Capitale) -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"roma"
   [{:culture/id "roma.dish.spaghetti-alla-carbonara"
     :culture/name "Spaghetti alla carbonara"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Pasta dish of eggs, hard cheese, cured pork and black pepper, typical of the Lazio region and strongly associated with Rome."
     :culture/url "https://en.wikipedia.org/wiki/Carbonara"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.dish.cacio-e-pepe"
     :culture/name "Cacio e pepe"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Pasta dish of grated pecorino romano and black pepper, typical of Lazio."
     :culture/url "https://en.wikipedia.org/wiki/Cacio_e_pepe"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.dish.saltimbocca"
     :culture/name "Saltimbocca"
     :culture/name-local "Saltimbocca alla romana"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Veal wrapped with prosciutto and sage; the original version is saltimbocca alla romana (Roman-style)."
     :culture/url "https://en.wikipedia.org/wiki/Saltimbocca"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.dish.carciofi-alla-giudia"
     :culture/name "Jewish-style artichokes"
     :culture/name-local "Carciofi alla giudia"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Fried artichokes, among the best-known dishes of Roman Jewish cuisine, originated in the Jewish community of Rome."
     :culture/url "https://en.wikipedia.org/wiki/Carciofi_alla_giudia"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.dish.suppli"
     :culture/name "Supplì"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Fried snacks consisting of a ball of rice with tomato sauce, typical of Roman cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Suppl%C3%AC"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.product.pecorino-romano"
     :culture/name "Pecorino romano"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :product
     :culture/summary "Hard, salty sheep-milk cheese with PDO status (1996), historically from the Rome region of Lazio."
     :culture/url "https://en.wikipedia.org/wiki/Pecorino_romano"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.beverage.frascati"
     :culture/name "Frascati"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :beverage
     :culture/summary "Italian white wine from the town of Frascati southeast of Rome, holding DOC status since 1966."
     :culture/url "https://en.wikipedia.org/wiki/Frascati_(wine)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.festival.festa-de-noantri"
     :culture/name "Festa de' Noantri"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :festival
     :culture/summary "Religious celebration in honor of the Blessed Virgin of Carmel, held 16-30 July in Rome's Trastevere district."
     :culture/url "https://it.wikipedia.org/wiki/Festa_de%27_Noantri"
     :culture/url-provenance :wikipedia-it
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "roma.heritage.colosseum"
     :culture/name "Colosseum"
     :culture/name-local "Colosseo"
     :culture/municipality "roma"
     :culture/country "ITA"
     :culture/kind :heritage
     :culture/summary "Elliptical amphitheatre in the centre of the city of Rome, landmark of the city."
     :culture/url "https://en.wikipedia.org/wiki/Colosseum"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-ita-roma culture catalog "
                 "(ADR-2607171400): " (count (get catalog "roma"))
                 " Roma entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
