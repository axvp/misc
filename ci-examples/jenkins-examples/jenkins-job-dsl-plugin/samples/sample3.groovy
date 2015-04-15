job {
	name 'Job with git repo clone'
	description 'This job clones a git repository'

	scm {
		git('https://github.com/tom1299/misc')
	}
	
	steps {
		shell ('echo \'Hello world\'')
	}
}
