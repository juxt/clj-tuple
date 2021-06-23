(defproject pro.juxt.clojars-mirrors.ztellman/clj-tuple "0.2.2"
  :description "Efficient small collections (mirrored from Clojars by JUXT)"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :url "https://github.com/ztellman/clj-tuple"
  :scm {:name "git"
        :url "https://github.com/juxt/clj-tuple"
        :dir "."}
  :dependencies []

  :profiles {:dev {:dependencies [[criterium "0.4.1"]
                                  [collection-check "0.1.5"]]}
             :provided {:dependencies [[org.clojure/clojure "1.7.0-alpha5"]]}}
  :global-vars {*warn-on-reflection* true}
  :test-selectors {:benchmark :benchmark
                   :stress :stress
                   :default #(every? (complement #{:benchmark :stress}) (keys %))}
  :java-source-paths ["src"]
  :javac-options ["-target" "1.5" "-source" "1.5"]
  :jvm-opts ^:replace ["-server" "-Xmx500m" "-XX:NewSize=200m"]

  ;; empty JARs to keep Maven Central happy
  :classifiers {:sources {:jar-exclusions [#""]}
                :javadoc {:jar-exclusions [#""]}}

  :pom-addition ([:developers
                  [:developer
                   [:id "ztellman"]
                   [:name "Zach Tellman"]]
                  [:developer
                   [:id "juxt"]
                   [:name "JUXT"]
                   [:roles [:role "packager"]]]])

  :deploy-repositories {"releases" {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2"
                                    :creds :gpg}
                        "snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots"
                                     :creds :gpg}})
