(ns day3-1)

(defn starting-corner [n]
  (let [root (long (Math/sqrt n))]
    (repeat 2 (quot (if (zero? (mod root 2))
                      (dec root) root) 2))
    ))

(defn starting-corner-number [n]
  (let [root (inc (* 2 (first (starting-corner n))))]
    (* root root)))

(defn nums-per-side [corner]
  (* 2 (inc (first corner))))

(defn move-to-target [start-n target-n]
  (let [start-corner (starting-corner start-n)]
    (if (= start-n target-n)
      start-corner
      (let [remainder (- target-n (inc start-n))
            spaces (nums-per-side start-corner)
            max-coord (inc (first start-corner))
            travel-dist (mod remainder spaces)]
        (case (quot remainder spaces)
          0 [max-coord (- (dec max-coord) travel-dist)]
          1 [(- (dec max-coord) travel-dist) (- max-coord)]
          2 [(- max-coord) (+ (inc (- max-coord)) travel-dist)]
          3 [(+ (inc (- max-coord)) travel-dist) (- max-coord)]
          )
        )
      ))
  )

(defn moves-required [n]
  (apply + (map (fn [^long n] (Math/abs n)) (move-to-target (starting-corner-number n) n))))

(doseq [n [2 11 25 26 36 265149]]
    (prn n (moves-required n)))
