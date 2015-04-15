package utilities

import javaposse.jobdsl.dsl.Job

public class JobDefaults {
  static addDefaults(Job job) {
      job.with {
		permission(Permissions.ItemRead, 'anonymous')
		permission(Permissions.ItemDiscover, 'anonymous')
     }
  }
}
