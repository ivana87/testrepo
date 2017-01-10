(defproject testapp "0.1.3"
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
  :plugins [[lein-release "1.0.5"]]
  ;:scm "https://github.com/ivana87/testrepo.git"
  ;:lein-release {:deploy-via :git}
  :deploy-repositories [["releases" {:url "http://localhost:8081/repository/maven-releases/"
                                     :username "admin" :password "admin123"
                                     :sign-releases false}]
                        ["snapshots" {:url "http://localhost:8081/repository/maven-snapshots/"
                                      :username "admin" :password "admin123"}]])
