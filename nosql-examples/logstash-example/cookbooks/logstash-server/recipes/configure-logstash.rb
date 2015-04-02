template "/opt/logstash-" + node['logstash-version'] + "/logstash-apache.conf" do
  source "opt/logstash/logstash-apache.conf.erb"
  action :create
end

bash 'start logstash' do
  user 'root'
  cwd "/opt/logstash-" + node['logstash-version']
  code <<-EOH
  nohup bin/logstash -f logstash-apache.conf &
  EOH
end
