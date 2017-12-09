(ns day5-1
  (:require [clojure.string :as string]))

(defn next-move [memory offset]
  (let [new-offset (+ offset (aget memory offset))]
    (do
      (aset-int memory offset (inc (aget memory offset)))
      new-offset)))

(defn moves-to-exit [memory]
  (let [steps (atom 0)
        offset (atom 0)]
    (do (while (nth memory @offset false)
      (do
        (swap! offset (partial next-move memory))
        (swap! steps inc)))
      @steps)))

(defn memory-from-file [file-name]
  (let [lines (string/trim (slurp file-name))]
    (int-array (map #(Integer/parseInt %) (.split lines "\n")))))

(let [memory (int-array '(0 3 0 1 -3))]
  (prn (next-move memory 0) (seq memory)))
(prn (moves-to-exit (int-array '(0 3 0 1 -3))))

(prn (moves-to-exit (memory-from-file "../data/day5-1.txt")))
