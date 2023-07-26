(ns bhlie.fcc.calculator.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :calculator/current-value
 :=> :value)