(defproject cauchy-jobs-http "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "2.0.0"]]
  :main ^:skip-aot clj-cauchy-jobs-http.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})