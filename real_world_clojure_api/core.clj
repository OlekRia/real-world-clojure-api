(ns real-world-clojure-api.core
  (:require [real-world-clojure-api.config :as config]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(defn respond-hello [request]
  {:status 200 :body "Hello, world!"})

(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]}))

(defn create-server [config]
  (http/create-server
   {::http/routes routes
    ::http/type :jetty
    ::http/port (-> config :server :port)}))

(defn start [config]
  (http/start (create-server config)))

(defn -main []
  (let [config (config/read-config)]
    (println "Starting API Service... " config)
    (start config)))