(ns day1-2
  (:require [clojure.string :as string])
  )

(defn input-to-seq [x]
  (map (fn [^Character x] (Integer/valueOf (.toString x)))
       (.toCharArray x))
  )

(defn captcha-sum-from-seq [input max-iter]
  (loop [loop-seq (cycle input)
         iter max-iter
         sum 0]
    (if (> iter 0)
      (recur (rest loop-seq)
             (dec iter)
             (if (= (first loop-seq) (nth loop-seq (/ max-iter 2)))
               (+ sum (first loop-seq))
               sum))
      sum)))

(defn captcha-sum [input]
  (captcha-sum-from-seq (input-to-seq input) (.length input)))

(prn (captcha-sum "1212"))
(prn (captcha-sum "1221"))
(prn (captcha-sum "123425"))
(prn (captcha-sum "123123"))
(prn (captcha-sum "12131415"))

(def file-input (string/trim (slurp "../data/day1-1.txt")))
(prn (captcha-sum file-input))