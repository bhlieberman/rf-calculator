(ns bhlie.fcc.calculator.events
  (:require [re-frame.core :refer [reg-event-fx reg-event-db path]]
            [bhlie.fcc.calculator.db :refer [default-db]]))

(reg-event-fx
 :initialize-app
 (fn [_ _]
   {:db default-db}))

(reg-event-db
 :calculator/update-expr
 (path :expr)
 (fn [expr [_ new-value]]
   (conj expr new-value)))

(reg-event-db
 :calculator/compute-expr
 (fn [{:keys [expr] :as db} _]
   (let [op-lookup {"+" +
                    "-" -
                    "/" /
                    "x" *}
         op (get op-lookup (second expr))
         val1 (first expr)
         val2 (last expr)]
     (cond
       (= op ".") (assoc db :expr [(apply str [val1 op val2])])
       :else (assoc db :answer (op val1 val2))))))

(reg-event-db
 :calculator/clear
 (fn [db _]
   (assoc db :value 0
          :expr [])))

(comment
  )