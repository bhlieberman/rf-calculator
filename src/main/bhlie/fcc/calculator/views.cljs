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
   [:div#numbers
    (for [i [{:el "AC" :id "clear"}
             {:el "/" :id "divide"}
             {:el "x" :id "mul"}
             7 8 9
             {:el "-" :id "minus"}
             4 5 6
             {:el "+" :id "plus"}
             1 2 3
             {:el "=" :id "equals"}
             0
             {:el "." :id "decimal"}]]
      (condp = (type i)
        js/Number [:div.calculator-button {:on-click click-to-update} i]
        cljs.core/PersistentArrayMap
        [:div.calculator-button {:on-click click-to-update
                                 :id (:id i)} (:el i)]))]])