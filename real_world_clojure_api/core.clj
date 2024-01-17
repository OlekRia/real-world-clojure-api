(ns real-world-clojure-api.core
  (:require [real-world-clojure-api.config :as config]))

(defn -main []
  (let [config (config/read-config)]
    (println "Starting API Service... " config)))