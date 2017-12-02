(ns day2-2)

(defn input-to-seqs [input]
  (map (fn [lines] (seq (map (fn [x] (Integer/parseInt x)) (.split lines "\t"))))
       (seq (.split input "\n")))
  )

(defn abs [^long x] (Math/abs x))

(defn checksum [data]
  (apply +
         (map (fn [row]
                (loop [values row
                       divisors row]
                  (if-not (first divisors)
                    (recur (rest values) row)
                    (if (and (not= (first values) (first divisors))
                             (= 0 (mod (first values) (first divisors))))
                      (abs (/ (first values) (first divisors)))
                      (recur values (rest divisors))))))
                data)
         ))

(def test-data (input-to-seqs "5\t9\t2\t8\n9\t4\t7\t3\n3\t8\t6\t5"))
(prn (checksum test-data))
(def puzzle-input (input-to-seqs (slurp "../data/day2-1.txt")))
(prn (checksum puzzle-input))