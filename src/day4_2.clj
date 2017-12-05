(ns day4-2
  (:require [clojure.string :as string])
  )

(defn valid-passphrase? [passphrase]
  (->> (.split passphrase " ")
       (map #(apply str (sort %)))
       (frequencies)
       (vals)
       (reduce max)
       (>= 1)))

(defn passphrases-from-file [file-input]
  (.split file-input "\n"))

(defn validity-to-number [validity]
  (if validity 1 0))

(defn valid-passphrases [passphrases]
  (apply + (map #(validity-to-number (valid-passphrase? %)) passphrases))
  )

(defn -main []
  (let [file-input (string/trim (slurp "data/day4-1.txt"))]
    (prn (valid-passphrases (passphrases-from-file file-input)))))

