### 2 fact Auth automate

Support for CI machines
Web sessions
To generate a web session for your CI machine, use

`fastlane spaceauth -u user@example.org`

This will authenticate you and provide a string that can be transferred to your CI system. Copy everything from ---\n to your CI server and provide it as environment variable named FASTLANE_SESSION. For example:

```
export FASTLANE_SESSION='---\n- !ruby/object:HTTP::Cookie\n  name: DES5c148586dfd451e55afbaaa5f62418f91\n  value: HSARMTKNSRVTWFla1+yO4gVPowH17VaaaxPFnUdMUegQZxqy1Ie1c2v6bM1vSOzIbuOmrl/FNenlScsd/NbF7/Lw4cpnL15jsyg0TOJwP32tC/NguPiyOaaaU+jrj4tf4uKdIywVaaaFSRVT\n  domain: idmsa.apple.com\n  for_domain: true\n  path: "/"\n  secure: true\n  httponly: true\n  expires: 2016-04-27 23:55:56.000000000 Z\n  max_age: \n  created_at: 2016-03-28 16:55:57.032086000 -07:00\n  accessed_at: 2016-03-28 19:11:17.828141000 -07:00\n'
```

