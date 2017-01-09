(defproject testapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring-server "0.4.0" :exclusions [hiccup]]
                 [com.github.lookfirst/sardine "5.0" :exclusions [commons-codec org.slf4j/slf4j-api]]
                 [commons-io/commons-io "2.4"]
                 [selmer "1.0.9"]
                 [environ "1.0.3"]
                 [clj-time "0.12.0"]]
  :main ^:skip-aot testapp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :deploy-repositories [["releases" {:url "http://localhost:8081/repository/lein-releases/"
                                     :username :env :password :env }]
                        ["snapshots" {:url "http://localhost:8081/repository/maven-snapshots/"
                                      :username :env :password :env}]])
