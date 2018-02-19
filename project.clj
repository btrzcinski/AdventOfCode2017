(defproject advent-of-code-2017 "0.1.0-SNAPSHOT"
  :description "Advent of Code 2017 Solutions"
  :url "https://www.github.com/btrzcinski/AdventOfCode2017"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :main ^:skip-aot day1-1.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
