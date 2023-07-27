(ns bhlie.fcc.calculator.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :calculator/current-value
 :=> :value)

(reg-sub
 :calculator/current-expr
 :=> :expr)

(reg-sub
 :display/show-expr
 :<- [:calculator/current-expr]
 :=> #(apply str %))