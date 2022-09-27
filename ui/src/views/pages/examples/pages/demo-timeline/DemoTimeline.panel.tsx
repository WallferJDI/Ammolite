import { Badge, Card, CardBody, CardHeader, Col, Container, Row } from "reactstrap";

import { BoxHeader } from "@/views/layout/headers";

export const DemoTimelinePanel = (): JSX.Element => {
  return (
    <>
      <BoxHeader />
      <Container className="mt--6" fluid>
        <Card className="mb-4">
          <CardHeader>
            <h3 className="mb-0">Timeline Demo Panel</h3>
          </CardHeader>
          <CardBody>
            <Row>
              <Col lg="6">
                <Card>
                  <CardHeader className="bg-transparent">
                    <h3 className="mb-0">Timeline</h3>
                  </CardHeader>
                  <CardBody>
                    <div
                      className="timeline timeline-one-side"
                      data-timeline-axis-style="dashed"
                      data-timeline-content="axis"
                    >
                      <div className="timeline-block">
                        <span className="timeline-step badge-success">
                          <i className="ni ni-bell-55" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-muted font-weight-bold">10:30 AM</small>
                          <h5 className="mt-3 mb-0">New message</h5>
                          <p className="text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="success" pill>
                              design
                            </Badge>
                            <Badge color="success" pill>
                              system
                            </Badge>
                            <Badge color="success" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-danger">
                          <i className="ni ni-html5" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-muted font-weight-bold">10:30 AM</small>
                          <h5 className="mt-3 mb-0">Product issue</h5>
                          <p className="text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="danger" pill>
                              design
                            </Badge>
                            <Badge color="danger" pill>
                              system
                            </Badge>
                            <Badge color="danger" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-info">
                          <i className="ni ni-like-2" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-muted font-weight-bold">10:30 AM</small>
                          <h5 className="mt-3 mb-0">New likes</h5>
                          <p className="text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="info" pill>
                              design
                            </Badge>
                            <Badge color="info" pill>
                              system
                            </Badge>
                            <Badge color="info" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-success">
                          <i className="ni ni-bell-55" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-muted font-weight-bold">10:30 AM</small>
                          <h5 className="mt-3 mb-0">New message</h5>
                          <p className="text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="success" pill>
                              design
                            </Badge>
                            <Badge color="success" pill>
                              system
                            </Badge>
                            <Badge color="success" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-danger">
                          <i className="ni ni-html5" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-muted font-weight-bold">10:30 AM</small>
                          <h5 className="mt-3 mb-0">Product issue</h5>
                          <p className="text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="danger" pill>
                              design
                            </Badge>
                            <Badge color="danger" pill>
                              system
                            </Badge>
                            <Badge color="danger" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                    </div>
                  </CardBody>
                </Card>
              </Col>
              <Col lg="6">
                <Card className="bg-gradient-default shadow">
                  <CardHeader className="bg-transparent">
                    <h3 className="mb-0 text-white">Dark timeline</h3>
                  </CardHeader>
                  <CardBody>
                    <div
                      className="timeline timeline-one-side"
                      data-timeline-axis-style="dashed"
                      data-timeline-content="axis"
                    >
                      <div className="timeline-block">
                        <span className="timeline-step badge-success">
                          <i className="ni ni-bell-55" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-light font-weight-bold">10:30 AM</small>
                          <h5 className="text-white mt-3 mb-0">New message</h5>
                          <p className="text-light text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="success" pill>
                              design
                            </Badge>
                            <Badge color="success" pill>
                              system
                            </Badge>
                            <Badge color="success" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-danger">
                          <i className="ni ni-html5" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-light font-weight-bold">10:30 AM</small>
                          <h5 className="text-white mt-3 mb-0">Product issue</h5>
                          <p className="text-light text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="danger" pill>
                              design
                            </Badge>
                            <Badge color="danger" pill>
                              system
                            </Badge>
                            <Badge color="danger" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-info">
                          <i className="ni ni-like-2" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-light font-weight-bold">10:30 AM</small>
                          <h5 className="text-white mt-3 mb-0">New likes</h5>
                          <p className="text-light text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="info" pill>
                              design
                            </Badge>
                            <Badge color="info" pill>
                              system
                            </Badge>
                            <Badge color="info" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-success">
                          <i className="ni ni-bell-55" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-light font-weight-bold">10:30 AM</small>
                          <h5 className="text-white mt-3 mb-0">New message</h5>
                          <p className="text-light text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="success" pill>
                              design
                            </Badge>
                            <Badge color="success" pill>
                              system
                            </Badge>
                            <Badge color="success" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                      <div className="timeline-block">
                        <span className="timeline-step badge-danger">
                          <i className="ni ni-html5" />
                        </span>
                        <div className="timeline-content">
                          <small className="text-light font-weight-bold">10:30 AM</small>
                          <h5 className="text-white mt-3 mb-0">Product issue</h5>
                          <p className="text-light text-sm mt-1 mb-0">
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Cum sociis
                            natoque penatibus et magnis dis parturient montes, nascetur ridiculus
                            mus.
                          </p>
                          <div className="mt-3">
                            <Badge color="danger" pill>
                              design
                            </Badge>
                            <Badge color="danger" pill>
                              system
                            </Badge>
                            <Badge color="danger" pill>
                              creative
                            </Badge>
                          </div>
                        </div>
                      </div>
                    </div>
                  </CardBody>
                </Card>
              </Col>
            </Row>
          </CardBody>
        </Card>
      </Container>
    </>
  );
};
