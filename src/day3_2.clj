(ns day3-2)

; x and y are in 'spiral dimension' (the down-right distance from the center)
; e.g., (0 0) is the center, (1 1) is one to the right and below the center,
; (-1 -1) is one above and to the left of the center

; i and j are actual matrix indices

(defn spiral-to-array-coords [matrix x y]
  (let [correction (quot (alength matrix) 2)]
    (list (+ x correction) (+ y correction))))

(defn set-value [matrix x y val]
  (let [array-coords (spiral-to-array-coords matrix x y)
        i (first array-coords)
        j (last array-coords)]
    (aset-int matrix i j val)))

(defn get-value [matrix x y]
  (let [array-coords (spiral-to-array-coords matrix x y)
        i (first array-coords)
        j (last array-coords)]
    (try
      (aget matrix i j)
      (catch ArrayIndexOutOfBoundsException e 0))))


(defn value-from-neighbors [matrix x y]
  (+ (get-value matrix (inc x) y)
     (get-value matrix (inc x) (inc y))
     (get-value matrix x (inc y))
     (get-value matrix (dec x) (inc y))
     (get-value matrix (dec x) y)
     (get-value matrix (dec x) (dec y))
     (get-value matrix x (dec y))
     (get-value matrix (inc x) (dec y))))

(defn set-and-check [matrix x y n]
  (let [new-value (value-from-neighbors matrix x y)]
    (do
      (set-value matrix x y new-value)
      (> new-value n))))

(defn spiral-towards [matrix n]
  (let [x (atom 1)
        y (atom 0)
        i (atom 1)]
    (do
    (while (<= (get-value matrix @x @y) n)
      ; go up
      (do
        (while (and (<= (get-value matrix @x @y) n) (> @y (- @i))) (if-not (set-and-check matrix @x @y n) (swap! y dec)))
        (while (and (<= (get-value matrix @x @y) n) (> @x (- @i))) (if-not (set-and-check matrix @x @y n) (swap! x dec)))
        (while (and (<= (get-value matrix @x @y) n) (< @y @i))     (if-not (set-and-check matrix @x @y n) (swap! y inc)))
        (while (and (<= (get-value matrix @x @y) n) (<= @x @i))    (if-not (set-and-check matrix @x @y n) (swap! x inc)))
        (swap! i inc)
        )
      )
      (list @x @y))))

(defn new-spiral-matrix []
  (let [new-array (make-array Integer/TYPE 99 99)]
    (do (set-value new-array 0 0 1) new-array)))

(doseq [n [806 265149]]
  (let [test-matrix (new-spiral-matrix)
        coords (spiral-towards test-matrix n)]
    (prn coords (apply get-value test-matrix coords))))


