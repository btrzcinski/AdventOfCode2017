(ns day6-1)

(defn next-memory-state [memory]
  (let [memory-length (count memory)
        max-blocks (apply max memory)
        rotate-n (count (take-while #(not= max-blocks %) memory))
        blocks-to-distribute (nth memory rotate-n)]
    (loop [new-memory (cons 0 (take (dec memory-length) (drop (inc rotate-n) (cycle memory))))
           blocks-left blocks-to-distribute]
      (if (pos? blocks-left)
        (recur
          (cons (inc (second new-memory)) (take (dec memory-length) (drop 2 (cycle new-memory))))
          (dec blocks-left))
        (take memory-length (drop (- memory-length (mod (+ rotate-n blocks-to-distribute) memory-length)) (cycle new-memory)))
        )
      )
    )
  )

(defn moves-to-repeat [original-memory]
  (loop [history (list (next-memory-state original-memory) original-memory)
         steps 1]
    (if (some #(= (first history) %) (rest history))
      steps
      (recur (list* (next-memory-state (first history)) history) (inc steps)))))

; Example
(prn (moves-to-repeat '(0 2 7 0)))

; From Day 6 input
(prn (moves-to-repeat '(11 11 13 7 0 15 5 5 4 4 1 1 7 1 15 11)))