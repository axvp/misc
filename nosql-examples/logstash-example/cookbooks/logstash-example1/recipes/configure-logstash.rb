template "/opt/logstash-" + node['logstash-version'] + "/logging.conf" do
  source "opt/logstash/logging.conf.erb"
      variables ({
      :httpd_config_name => node['httpd']['config_name'],
      :tomcat_exact_version => node['tomcat']['exact_version']
    })
  owner 'root'
  group 'root'
  mode '0644'
  action :create
end

bash 'start logstash' do
  user 'root'
  cwd "/opt/logstash-" + node['logstash-version']
  code <<-EOH
  nohup bin/logstash -f logging.conf &
  EOH
end