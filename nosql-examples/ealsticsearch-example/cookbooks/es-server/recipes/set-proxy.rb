log "Setting proxies"
unless node['es-server'].nil?
	log "Setting es server attributes"
	node['es-server'].each_pair do |name, value|
		unless value.nil?
			log "Setting env var " + name + " to value " + value
			magic_shell_environment name do
				value value
			end
		end
	end
end
 
