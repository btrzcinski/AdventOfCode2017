(ns day4-2-tests
  [:use clojure.test
   :require day4-2])

(deftest valid
  (is (day4-2/valid-passphrase? "abcde fghij"))
  (is (day4-2/valid-passphrase? "a ab abc abd abf abj"))
  (is (day4-2/valid-passphrase? "iiii oiii ooii oooi oooo")))

(deftest invalid
  (is (not (day4-2/valid-passphrase? "abcde xyz ecdab")))
  (is (not (day4-2/valid-passphrase? "oiii ioii iioi iiio"))))

(run-tests)