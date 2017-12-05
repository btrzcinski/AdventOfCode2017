(ns day4-1
  (:require [clojure.string :as string])
  )

(defn valid-passphrase? [passphrase]
  (->>
    (-> passphrase
        (.split " ")
        (frequencies)
        (vals))
    (reduce max)
    (>= 1)))

(defn passphrases-from-file [file-input]
  (.split file-input "\n"))

(defn validity-to-number [validity]
  (if validity 1 0))

(defn valid-passphrases [passphrases]
  (apply + (map #(validity-to-number (valid-passphrase? %)) passphrases))
  )

(prn (valid-passphrase? "aa bb cc dd ee"))
(prn (valid-passphrase? "aa bb cc dd aa"))
(prn (valid-passphrase? "aa bb cc dd aaa"))

(def file-input (string/trim (slurp "../data/day4-1.txt")))
(prn (valid-passphrases (passphrases-from-file file-input)))
