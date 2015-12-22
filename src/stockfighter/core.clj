(ns stockfighter.core
  (:require
    [cheshire]
    [clj-http.client :as http]))

(def url "https://api.stockfighter.io/ob/api")

(defn stock-url [venue stock]
  (str url "/venues/" venue "/stocks/" stock))

(defn orderbook [venue stock]
  (http/get (stock-url venue stock)))

(defn buy [venue stock qty]
  (let [url (str (stock-url venue stock) "/orders")]
    (http/post url {:form-params
                    {:account account
                     :qty qty
                     :direction "buy"
                     :orderType "market"}
                    :content-type :json})))

(buy "IHKEX" "UGBE" 100)
