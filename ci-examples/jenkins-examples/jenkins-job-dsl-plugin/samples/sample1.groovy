job {
	name 'Very basic freestyle job'
	description 'Just contais a very basic jenkins job that echos "Hello world"'
	
	steps {
		shell ('echo \'Hello world\'')
	}
}
