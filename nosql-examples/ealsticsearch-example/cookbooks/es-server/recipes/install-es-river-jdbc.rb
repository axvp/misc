node.set['mysql']['java-connector-version'] = '5.1.33'


execute "Installing elastic search river jdbc plugin" do
  command "/usr/local/elasticsearch/bin/plugin --install jdbc --url http://xbib.org/repository/org/xbib/elasticsearch/plugin/elasticsearch-river-jdbc/1.5.0.0/elasticsearch-river-jdbc-1.5.0.0.zip"
end

service "elasticsearch" do
  action :stop
end

remote_file "#{Chef::Config[:file_cache_path]}/mysql-connector-java-" + node['mysql']['java-connector-version'] + ".zip" do
  source "http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-" + node['mysql']['java-connector-version'] + ".zip"
end

execute "Unzipping mysql connector" do
  command "unzip -o" + "#{Chef::Config[:file_cache_path]}/mysql-connector-java-" + node['mysql']['java-connector-version'] + ".zip -o -d " + "#{Chef::Config[:file_cache_path]}"
end

directory "/usr/local/elasticsearch/plugins/jdbc" do
  owner 'root'
  group 'root'
  mode '0755'
  action :create
end

execute "Copying mysql conector jar" do
  command "cp  " + "#{Chef::Config[:file_cache_path]}/mysql-connector-java-" + node['mysql']['java-connector-version'] + "/*.jar /usr/local/elasticsearch/plugins/jdbc"
end

service "elasticsearch" do
  action :start
end
