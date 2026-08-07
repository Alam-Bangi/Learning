| Regex           | Use                                                  |             |
| --------------- | ---------------------------------------------------- | ----------- |
| `.`             | Matches any single character (except newline)        |             |
| `^`             | Start of string/line                                 |             |
| `$`             | End of string/line                                   |             |
| `\A`            | Start of input                                       |             |
| `\Z`            | End of input (before final newline)                  |             |
| `\z`            | Absolute end of input                                |             |
| `*`             | Previous character/group appears **0 or more** times |             |
| `+`             | Previous character/group appears **1 or more** times |             |
| `?`             | Previous character/group appears **0 or 1** time     |             |
| `{n}`           | Exactly `n` occurrences                              |             |
| `{n,}`          | At least `n` occurrences                             |             |
| `{n,m}`         | Between `n` and `m` occurrences                      |             |
| `[abc]`         | Matches `a`, `b`, or `c`                             |             |
| `[^abc]`        | Matches anything except `a`, `b`, or `c`             |             |
| `[a-z]`         | Any lowercase letter                                 |             |
| `[A-Z]`         | Any uppercase letter                                 |             |
| `[0-9]`         | Any digit                                            |             |
| `[a-zA-Z]`      | Any letter                                           |             |
| `[a-zA-Z0-9]`   | Any letter or digit                                  |             |
| `-`             | Specifies a range inside `[]`                        |             |
| `()`            | Capturing group                                      |             |
| `(?:...)`       | Non-capturing group                                  |             |
| `               | `                                                    | OR operator |
| `\d`            | Any digit (`0–9`)                                    |             |
| `\D`            | Any non-digit                                        |             |
| `\w`            | Word character (`a-z`, `A-Z`, `0-9`, `_`)            |             |
| `\W`            | Non-word character                                   |             |
| `\s`            | Whitespace (space, tab, newline)                     |             |
| `\S`            | Non-whitespace                                       |             |
| `\h`            | Horizontal whitespace                                |             |
| `\H`            | Non-horizontal whitespace                            |             |
| `\v`            | Vertical whitespace                                  |             |
| `\V`            | Non-vertical whitespace                              |             |
| `\b`            | Word boundary                                        |             |
| `\B`            | Not a word boundary                                  |             |
| `(?=...)`       | Positive lookahead                                   |             |
| `(?!...)`       | Negative lookahead                                   |             |
| `(?<=...)`      | Positive lookbehind                                  |             |
| `(?<!...)`      | Negative lookbehind                                  |             |
| `\1`, `\2`, ... | Backreference to captured groups                     |             |
| `.*`            | Greedy match (as much as possible)                   |             |
| `.*?`           | Lazy/reluctant match (as little as possible)         |             |
| `.*+`           | Possessive match (no backtracking)                   |             |
| `\p{Lower}`     | Lowercase Unicode letter                             |             |
| `\p{Upper}`     | Uppercase Unicode letter                             |             |
| `\p{Digit}`     | Unicode digit                                        |             |
| `\p{Alpha}`     | Unicode alphabetic character                         |             |
| `\p{Alnum}`     | Unicode alphanumeric character                       |             |
| `\p{Punct}`     | Unicode punctuation                                  |             |
| `\p{Space}`     | Unicode whitespace                                   |             |
| `\p{ASCII}`     | ASCII character                                      |             |
| `\.`            | Literal `.`                                          |             |
| `\*`            | Literal `*`                                          |             |
| `\+`            | Literal `+`                                          |             |
| `\?`            | Literal `?`                                          |             |
| `\\`            | Literal backslash (`\`)                              |             |
| `\(`            | Literal `(`                                          |             |
| `\)`            | Literal `)`                                          |             |
| `\[`            | Literal `[`                                          |             |
| `\]`            | Literal `]`                                          |             |
| `\{`            | Literal `{`                                          |             |
| `\}`            | Literal `}`                                          |             |
| `\|`            | Literal `                                            | `           |
| `\^`            | Literal `^`                                          |             |
| `\$`            | Literal `$`                                          |             |

**Java reminder:** In Java string literals, escape each backslash. For example:

* Regex `\d+` → Java string `"\\d+"`
* Regex `\s*` → Java string `"\\s*"`
* Regex `\bword\b` → Java string `"\\bword\\b"`
