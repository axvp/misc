def branches = [ 'main', "feature_a"]

branches.each { branch ->
	job {
		name "Job for building branch $branch"
		description "This job builds branch $branch"
	
		scm {
			git('https://github.com/tom1299/misc', branch)
		}
	
		steps {
			shell ("echo 'Building branch $branch'")
		}	
	}	
}
