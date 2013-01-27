#!/bin/bash
set -x

# Run OTP tests
#
# Set your paths below
#
OTP_TOP="/home/karl/Projects/otp/"
OTP_TEST_DIR="/home/karl/Projects/otp/release/tests"
TEST_LOG_BASE="/home/karl/tmp/otp_tests/logs"


TEST_DIRS=$(find ${OTP_TEST_DIR} -maxdepth 1 -name '*_test')

cd ${OTP_TEST_DIR}/test_server
$OTP_TOP/bin/erl -run ts install -run erlang halt

for DIR in ${TEST_DIRS}; do
	
	LOGDIR="${TEST_LOG_BASE}/$(basename $DIR)_logs"
	echo "processing $DIR ($LOGDIR)"
	SPECS=$(find $DIR -maxdepth 1 -name '*.spec')
	echo "Spec:  $SPECS"
	mkdir -p ${LOGDIR}
	$OTP_TOP/bin/ct_run -label $(basename $SPECS) -dir ${DIR} -spec ${SPECS} -logdir ${LOGDIR} -ct_hooks cth_surefire -boot start_sasl
	
done