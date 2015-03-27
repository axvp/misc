# Put this in attrbutes file
node.set['mysql']['java-connector-version'] = '5.1.33'

# Replace hard coded vesion with variable
execute "Installing elastic search river jdbc plugin" do
  command "/usr/share/elasticsearch/bin/plugin --install jdbc --url http://xbib.org/repository/org/xbib/elasticsearch/plugin/elasticsearch-river-jdbc/1.5.0.0/elasticsearch-river-jdbc-1.5.0.0.zip"
end

service "elasticsearch" do
  action :stop
end

remote_file "#{Chef::Config[:file_cache_path]}/mysql-connector-java-" + node['mysql']['java-connector-version'] + ".zip" do
  source "http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-" + node['mysql']['java-connector-version'] + ".zip"
end

# Find a better way to unzip
execute "Unzipping mysql connector" do
  command "unzip -o " + "#{Chef::Config[:file_cache_path]}/mysql-connector-java-" + node['mysql']['java-connector-version'] + ".zip -d " + "#{Chef::Config[:file_cache_path]}"
end

directory "/usr/share/elasticsearch/plugins/jdbc" do
   owner 'elasticsearch'
   group 'elasticsearch'
   mode '0755'
   action :create
end

execute "Copying mysql conector jar" do
   command "cp " + "#{Chef::Config[:file_cache_path]}/mysql-connector-java-" + node['mysql']['java-connector-version'] + "/*.jar /usr/share/elasticsearch/plugins/jdbc"
end

file "/usr/share/elasticsearch/plugins/jdbc/mysql-connector-java-" + node['mysql']['java-connector-version'] + ".jar" do
   owner 'elasticsearch'
   group 'elasticsearch'
   mode '0755'
   action :create_if_missing 
end

service "elasticsearch" do
  action :start
end
