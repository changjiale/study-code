### leads-platform-go
线索接口层

## Initialization for automated tests

1. Install ginkgo and gomega


    go get github.com/onsi/ginkgo/ginkgo
    go get github.com/onsi/gomega/...

2. Install database dependencies

    go get github.com/mattn/go-sqlite3
    go get github.com/icrowley/fake
    go get github.com/corpix/uarand
    go get golang.org/x/tools/cmd/cover

3. Install utilities for test report

    go get github.com/axw/gocov/gocov
    go get github.com/AlekSi/gocov-xml
    go get github.com/matm/gocov-html
    go get github.com/wadey/gocovmerge

## How to run all test

1. export LEADS_PLATFORM_ENV=testing
2. make test

Without `export LEADS_PLATFORM_ENV=testing`, there will be log files inside of tests/unit

## How to generate code coverage report

1. export LEADS_PLATFORM_ENV=testing
2. make report