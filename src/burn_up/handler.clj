(ns burn-up.handler
  (:use compojure.core
        ring.util.response)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/hello" [] (file-response "welcome.html" {:root "resources/public"}))
  (route/resources "/")
  (route/not-found (file-response "404.html" {:root "resources/html"})))

(def app
  (handler/site app-routes))
