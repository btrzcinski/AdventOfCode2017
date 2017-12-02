(ns day2-1
  (:require [clojure.string :as string]))

(defn input-to-seqs [input]
  (map (fn [lines] (seq (map (fn [x] (Integer/parseInt x)) (.split lines "\t"))))
       (seq (.split input "\n")))
  )

(defn checksum [data]
  (apply + (map #(- (apply max %) (apply min %)) data)))

(def test-data (input-to-seqs "5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8\n"))
(prn (checksum test-data))
(def puzzle-input (input-to-seqs (slurp "../data/day2-1.txt")))
(prn (checksum puzzle-input))

