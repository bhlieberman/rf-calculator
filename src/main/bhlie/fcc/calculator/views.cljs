(ns bhlie.fcc.calculator.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [bhlie.fcc.calculator.subs]))

(defn click-to-update [e]
  (dispatch [:calculator/update-expr (.. e -target -textContent)]))

(defn calculate-answer [_]
  (dispatch [:calculator/compute-expr]))

(defn clear-screen [_]
  (dispatch [:calculator/clear]))

(defn current-value []
  [:div#display
   [:p#expr @(subscribe [:display/show-expr])]
   [:span#current-value @(subscribe [:calculator/current-value])]])

(defn calculator []
  [:div#calculator
   [current-value]
   [:div#numbers
    (for [i [{:el "AC" :id "clear" :on-click clear-screen}
             {:el "/" :id "divide"}
             {:el "x" :id "multiply"}
             {:el 7 :id "seven"}
             {:el 8 :id "eight"} 
             {:el 9 :id "nine"}
             {:el "-" :id "subtract"}
             {:el 4 :id "four"} 
             {:el 5 :id "five"}
             {:el 6 :id "six"}
             {:el "+" :id "add"}
             {:el 1 :id "one"}
             {:el 2 :id "two"}
             {:el 3 :id "three"}
             {:el "=" :id "equals"}
             {:el 0 :id "zero"}
             {:el "." :id "decimal"}]]
      (if (= (:el i) "=")
        [:div.calculator-button {:on-click calculate-answer
                                 :id "equals"} "="]
        [:div.calculator-button {:on-click (or (:on-click i) click-to-update)
                                 :id (:id i)} (:el i)]))]])