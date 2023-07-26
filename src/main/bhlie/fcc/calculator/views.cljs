(ns bhlie.fcc.calculator.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [bhlie.fcc.calculator.subs]))

(defn click-to-update [e]
  (dispatch [:calculator/update-current-value (.. e -target -textContent)]))

(defn current-value []
  [:div#calculator-display
   [:span#current-value @(subscribe [:calculator/current-value])]])

(defn calculator [] 
  [:div#calculator
   [current-value]
   [:table
    [:tbody
     [:tr
      [:td.calculator-button {:on-click click-to-update} 7] 
      [:td.calculator-button {:on-click click-to-update} 8]
      [:td.calculator-button {:on-click click-to-update} 9]
      [:td.calculator-button {:on-click click-to-update} "-"]]
     [:tr
      [:td.calculator-button {:on-click click-to-update} 4]
      [:td.calculator-button {:on-click click-to-update} 5]
      [:td.calculator-button {:on-click click-to-update} 6]
      [:td.calculator-button {:on-click click-to-update} "+"]]
     [:tr
      [:td.calculator-button {:on-click click-to-update} 1]
      [:td.calculator-button {:on-click click-to-update} 2]
      [:td.calculator-button {:on-click click-to-update} 3]]
     [:tr
      [:td.calculator-button {:on-click click-to-update} 0]
      [:td.calculator-button {:on-click click-to-update} "."]]]]])
