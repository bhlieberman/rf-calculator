(ns bhlie.fcc.calculator.events
  (:require [re-frame.core :refer [reg-event-fx reg-event-db]]
            [bhlie.fcc.calculator.db :refer [default-db]]))

(reg-event-fx
 :initialize-app
 (fn [_ _]
   {:db default-db}))

(reg-event-db
 :calculator/update-current-value
 (fn [db [_ new-value]]
   (let [current-value (:value db)
         current-op (:operation db)]
     {:value (if (some? current-op)
               (current-op current-value new-value)
               new-value)
      :operation nil})))