(ns cauchy.jobs.http
    (:require [clj-http.client :as http]))

(defn get-state-with-threshold
  "threshold comparator"
  [{:keys [warn crit comp] :as conf} metric]
  (cond
   (comp metric crit) "critical"
   (comp metric warn) "warning"
   :else "ok"))

(def default-code-threshold
  { "status-code" { :warn 400 :crit 500 :comp >}
    "request-time" {:warn 1000 :crit 4000 :comp >}})

(defn get-http-data
 "retrieve url status"
  [{:keys [protocol host port path] :or {protocol "http" host "localhost" port "80" path "/"}}]
  (let [url (str protocol "://" host ":" port path)]
    (http/get url {:throw-exceptions false})))

(defn http-health
 "Main http checker"
 ([{:keys [protocol host port path thresholds] :as conf}]
  (let [thresholds (merge-with merge default-code-threshold thresholds)
        resp (get-http-data conf)
        sstate (get-state-with-threshold (get thresholds "status-code") (:status resp))
        lstate (get-state-with-threshold (get thresholds "request-time") (:request-time resp))]
       [{:service "status"
         :state sstate}
        {:service "request-time"
         :state lstate
         :metric (:request-time resp)}]))
  ([] (http-health{})))
