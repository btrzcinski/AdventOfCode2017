(ns day1-1.core
  (:require [clojure.string :as string])
  )

(defn input-to-seq [x]
  (map (fn [^Character x] (Integer/valueOf (.toString x)))
     (.toCharArray x))
  )

(defn captcha-sum-from-seq [input]
  (loop [loop-seq input
         sum 0]
    (if (second loop-seq)
      (recur (rest loop-seq)
             (if (= (first loop-seq) (second loop-seq))
               (+ sum (first loop-seq))
               sum))
      sum)))

(defn captcha-sum [input]
  (captcha-sum-from-seq (cons (last (input-to-seq input)) (input-to-seq input))))

(defn -main [& args]
  (prn (captcha-sum "1122"))
  (prn (captcha-sum "1111"))
  (prn (captcha-sum "1234"))
  (prn (captcha-sum "91212129"))

  (def file-input (string/trim (slurp "resources/day1-1.txt")))
  (prn (captcha-sum file-input))
  )
