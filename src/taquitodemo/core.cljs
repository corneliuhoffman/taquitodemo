(ns taquitodemo.core
(:require [reagent.core :as r]
          [reagent.dom :as rdom]
          [org.parkerici.blockoid.core :as bo])  )

(def tezos (js/taquito.TezosToolkit. "https://mainnet.api.tez.ie"))



(defn add [address] (.getBalance tezos.rpc address))
(defn cp [a b] [:div [:div  "the address is "] [:p  {:style {:color "red"}} [:b a]] [:div " and the balance is:"][:p [:b b]]])
(defn render [address] (.then (add address) #(rdom/render [cp  address (str (/ % 1000000) "ꜩ") ](.getElementById js/document "app"))))


