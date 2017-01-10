(ns testapp.other)



(defn sign [x]
  (if (< x 0)
    "-"
    "+"
    ))

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])
                     )
               )
        )
      )
    )
  )
; !!!! map works with vectors and lists on the same way.
; calling seq to make a list
; calling into to set it to original values
;mapping 2 collections. same number of args
; map pass the collection of functions
; reduce works on vectors e.g. []
; syntax map function is diff than haskell...
; ClojureMap ( Fmap, Vn)=> [ Fmap(V1),.., Fmap(Vn)]
; map - pass also list of functions
; map keywords as functions. Wow...
; assoc - builds a map from map, key and value
;take and drop on the sequence
; take-while on processed and sorted data- makes sense. performance wise...
; some - when we just need to check if at least one element for the collection satisfies one condition
; sort and sort-by
; small change, another change


(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))


; sum [2 4 5 10]

; if lenght of list=1; then it is that element
; if length of list>1 then it is ACC+


; my way of defining the sum of numbers
(defn sum1
  [numbers]
  ;starting loop from here
  (loop [acc 0
         restnum numbers]
    (if (= (count rest) 0)
      acc
      (recur (+ acc (first restnum)) (rest restnum)))))

