(ns day4-2-tests
  (:use [clojure.test])
  (:require [day4-2 :refer [valid-passphrase?]]))

(deftest valid
  (is (valid-passphrase? "abcde fghij"))
  (is (valid-passphrase? "a ab abc abd abf abj"))
  (is (valid-passphrase? "iiii oiii ooii oooi oooo")))

(deftest invalid
  (is (not (valid-passphrase? "abcde xyz ecdab")))
  (is (not (valid-passphrase? "oiii ioii iioi iiio"))))

(run-tests)