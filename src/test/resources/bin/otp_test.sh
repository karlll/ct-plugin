#!/bin/bash
OTP_TEST_DIR=${$1-"\/Users\/a2l\/Projects\/otp\/otp_test"}
TEST_LOG_BASE="/Users/a2l/Projects/otp/otp_test/logs"

echo $OTP_TEST_DIR
exit

TEST_DIRS=$(find ${OTP_TEST_DIR} -d 1 -name '*_test')


for DIR in ${TEST_DIRS}; do
	LOGDIR="${TEST_LOG_BASE}/$(basename $DIR)_logs"
	echo "processing $DIR ($LOGDIR)"
	SPECS=$(find $DIR -d 1 -name '*.spec')
	echo " $SPECS"
	mkdir -p ${LOGDIR}
	ct_run -spec ${SPECS} -logdir ${LOGDIR}
	exit
done