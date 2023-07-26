(ns bhlie.fcc.calculator.core
  (:require [re-frame.core :as rf :refer [dispatch-sync]]
            [reagent.core :as r]
            [reagent.dom.client :refer [create-root]]
            [goog.dom :as gdom]
            [bhlie.fcc.calculator.events]
            [bhlie.fcc.calculator.views :refer [calculator]]))

(defonce root (create-root (gdom/getElement "root")))

(defn render []
  (.render root (r/as-element [:div  
                               [calculator]])))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn ^:dev/after-load clear-cache-and-render! []
  (rf/clear-subscription-cache!)
  (render))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn init []
  (dispatch-sync [:initialize-app]) 
  (render))