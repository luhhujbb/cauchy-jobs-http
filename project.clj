(defproject cauchy-jobs-http "0.1.1"
  :description "HTTP Checker for cauchy"
  :url "https://github.com/luhhujbb/cauchy-jobs-http"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "2.0.0"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
