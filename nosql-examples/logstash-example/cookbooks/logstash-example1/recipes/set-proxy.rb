log "Setting proxies"
unless node['logstash-example1'].nil?
        log "Setting logstash example1 attributes"
        node['logstash-example1'].each_pair do |name, value|
                unless value.nil?
                        log "Setting env var " + name + " to value " + value
                        magic_shell_environment name do
                                value value
                        end
                end
        end
end

