log "Setting proxies"
unless node['logstash-server'].nil?
        log "Setting logstash server attributes"
        node['logstash-server'].each_pair do |name, value|
                unless value.nil?
                        log "Setting env var " + name + " to value " + value
                        magic_shell_environment name do
                                value value
                        end
                end
        end
end

