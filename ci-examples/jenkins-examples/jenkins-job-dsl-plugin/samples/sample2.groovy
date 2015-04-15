import utilities.JobDefaults

def job = job {
	name 'Job with script include'
	description 'Contains an include of a script'
	
	steps {
		shell readFileFromWorkspace('/scripts/helloworld.sh')
	}
}

JobDefaults.addDefaults(job)
